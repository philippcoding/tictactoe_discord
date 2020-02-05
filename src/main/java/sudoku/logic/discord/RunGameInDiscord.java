package sudoku.logic.discord;

import discord.DiscordApp;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import sudoku.gui.ConsoleDisplay;
import sudoku.logic.MoveValidation;
import sudoku.logic.SolutionCheck;
import sudoku.model.Cell;
import sudoku.model.Grid;
import sudoku.model.PlayerMove;
import sudoku.model.Row;

import java.util.HashMap;

import static sudoku.logic.console.RunGameInConsole.cleanInput;

public class RunGameInDiscord {
    // Class Variables
    private Grid grid;
    private String input;
    private String preset;
    private GuildMessageReceivedEvent event;
    private MessageChannel channel;

    public RunGameInDiscord(Grid grid, String preset, GuildMessageReceivedEvent event){
        this.grid = grid;
        this.input = "";
        this.preset = preset;
        this.event = event;
        this.channel = event.getChannel();
    }

    // Methods
    private void setCellValue(HashMap<String, Integer> move) {
        int x = move.get("X") - 1;
        int y = move.get("Y") - 1;

        int value = move.get("Value");

        Row row = this.grid.getGrid().get(y);
        Cell cell = row.getRowOfCells().get(x);

        cell.setValue(value);
    }

    public String discordInputLoop(){
        boolean keepInputting = true;
        String input = "";

        while(keepInputting) {
            this.channel.sendMessage(ConsoleDisplay.userPromptAsString());
            input = this.event.getMessage().getContentRaw();

            System.out.println(input);
            if(input.startsWith(DiscordApp.prefix)){
                input = input.replace(DiscordApp.prefix + "sd", "");

                if(input.equals("-1")) {
                    this.channel.sendMessage(ConsoleDisplay.endGamePromptString()).queue();
                    return "-1";
                }

                if(input.toLowerCase().startsWith("c")){
                    this.channel.sendMessage("\nChecking grid...").queue();
                    return "c";
                }
                // DO LATER
//            else if(input.toLowerCase().startsWith("c")){
//                // add logic for checking board for win
//            }
                else{
                    input = cleanInput(input);
                }

                if(MoveValidation.inputIsValid(input)) {
                    keepInputting = false;
                }
                else{
                    this.channel.sendMessage(ConsoleDisplay.wrongInputString()).queue();
                }
            }
        }
        return input;
    }

    public void runGame(){
        PlayerMove move;
        boolean keepPlaying = true;
        if(!this.preset.isEmpty()){
            this.grid.createGrid(this.preset);
        }
        if(this.grid.getGridTotal() == 0){
            this.grid.createGrid();
        }

        while(keepPlaying){
            this.channel.sendMessage(ConsoleDisplay.titleGame()).queue();
            ConsoleDisplay.displayGame(this.grid);

            this.input = discordInputLoop();

            // end game/ break loop
            if(this.input.equals("-1")){
                break;
            }

            if(this.input.equals("c")){
                this.channel.sendMessage(SolutionCheck.checkSolution(this.grid)).queue();
                break;
            }

            // set move
            move = new PlayerMove(this.input);
            setCellValue(move.getMoveMap());
        }
        this.channel.sendMessage("Game has ended!").queue();
    }


}
