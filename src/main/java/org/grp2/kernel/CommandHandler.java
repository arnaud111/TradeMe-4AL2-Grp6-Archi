package org.grp2.kernel;

public interface CommandHandler extends Command {
    void handle(Command command);
}
