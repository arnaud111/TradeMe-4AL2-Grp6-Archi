package org.grp2.kernel;

import java.util.HashMap;
import java.util.Map;

public class CommandBus {
    private final Map<Class<? extends Command>, CommandHandler> handlers;

    CommandBus() {
        this.handlers = new HashMap<>();
    }

    <C extends Command> void register(Class<C> commandType, CommandHandler handler) {
        handlers.put(commandType, handler);
    }

    void dispatch(Command command) {
        CommandHandler handler = handlers.get(command.getClass());
        if (handler == null) {
            throw new IllegalArgumentException("No handler registered for command type " + command.getClass());
        }
        handler.handle(command);
    }
}
