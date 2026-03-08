package io.kcache.kwack.sqlline;

import sqlline.Application;
import sqlline.BuiltInProperty;
import sqlline.PromptHandler;
import sqlline.SqlLine;
import sqlline.SqlLineOpts;
import java.util.Random;

public class KwackApplication extends Application {

    public KwackApplication() {
        super();
    }


    private final Random random = new Random();

    // ANSI Color and Reset Codes
    private static final String RESET = "\u001B[0m";
    private static final String WATER_COLOR = "\u001B[34m"; // Constant blue for the waves
    private static final String TITLE_COLOR = "\u001B[1;37m"; // Bold White

    // A rich palette of background-safe colors
    private static final String[] PALETTE = {
        "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[35m", "\u001B[36m", // Normal
        "\u001B[31;1m", "\u001B[32;1m", "\u001B[33;1m", "\u001B[35;1m", "\u001B[36;1m" // Bright
    };

    /**
     * Helper to get a random color code from the palette.
     */
    private String randomColor() {
        return PALETTE[random.nextInt(PALETTE.length)];
    }

    @Override
    public SqlLineOpts getOpts(SqlLine sqlline) {
        SqlLineOpts opts = super.getOpts(sqlline);
        opts.set(BuiltInProperty.CONNECT_INTERACTION_MODE, "notAskCredentials");
        opts.set(BuiltInProperty.MAX_WIDTH, 120);
        return opts;
    }

    @Override
    public PromptHandler getPromptHandler(SqlLine sqlLine) {
        return new KwackPromptHandler(sqlLine);
    }

@Override
    public String getInfoMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(TITLE_COLOR).append("Welcome to omni-kwack!").append(RESET).append("\n");
        sb.append("Flexible Kafka to DuckDB Ingestion\n");
        sb.append("Enter \"!help\" for usage hints.\n\n");

        // The exact visible width of each element is preserved for perfect alignment.

        // LINE 1: The Heads
        sb.append("      "); // Preserved leading spaces (6)

        // Duck 1 Head Parts
        sb.append(randomColor()).append("___").append(RESET); // Head Back (3)
        sb.append(randomColor()).append("(").append(RESET);   // Beak Hinge (1)
        sb.append(randomColor()).append(".").append(RESET);   // Eye (1)
        sb.append(randomColor()).append(")").append(RESET);   // Face (1)
        sb.append(randomColor()).append(">").append(RESET);   // Beak Tip (1)

        sb.append("           "); // Preserved space between heads (11)

        // Duck 2 Head Parts
        sb.append(randomColor()).append("___").append(RESET);
        sb.append(randomColor()).append("(").append(RESET);
        sb.append(randomColor()).append(".").append(RESET);
        sb.append(randomColor()).append(")").append(RESET);
        sb.append(randomColor()).append(">");

        sb.append("           "); // Preserved space between heads (11)

        // Duck 3 Head Parts
        sb.append(randomColor()).append("___").append(RESET);
        sb.append(randomColor()).append("(").append(RESET);
        sb.append(randomColor()).append(".").append(RESET);
        sb.append(randomColor()).append(")").append(RESET);
        sb.append(randomColor()).append(">");

        sb.append("\n"); // End of head line

        // LINE 2: The Bodies and the "Stream" (Water)
        sb.append(WATER_COLOR).append("~~~~~~").append(RESET); // Leading water (6)

        // Duck 1 Body Parts
        sb.append(randomColor()).append("\\").append(RESET);   // Neck Connector (1)
        sb.append(randomColor()).append("___").append(RESET); // Main Body (3)
        sb.append(randomColor()).append(")").append(RESET);   // Tail (1)

        // Water between bodies
        sb.append(WATER_COLOR).append("~~~~~~~~~~~~~").append(RESET); // Water space (13)

        // Duck 2 Body Parts
        sb.append(randomColor()).append("\\").append(RESET);
        sb.append(randomColor()).append("___").append(RESET);
        sb.append(randomColor()).append(")").append(RESET);

        // Water between bodies
        sb.append(WATER_COLOR).append("~~~~~~~~~~~~~").append(RESET); // Water space (13)

        // Duck 3 Body Parts
        sb.append(randomColor()).append("\\").append(RESET);
        sb.append(randomColor()).append("___").append(RESET);
        sb.append(randomColor()).append(")").append(RESET);

        // Trailing water
        sb.append(WATER_COLOR).append("~~~~~~").append(RESET); // End of body line

        return sb.toString();
    }
}
