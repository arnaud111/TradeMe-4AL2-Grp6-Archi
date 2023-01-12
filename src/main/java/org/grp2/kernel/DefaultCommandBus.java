package org.grp2.kernel;

import java.util.HashMap;
import java.util.Map;

class DefaultCommandBus extends CommandBus {
    private final Map<Class<? extends Command>, CommandHandler> handlers;

    DefaultCommandBus() {
        this.handlers = new HashMap<>();
    }

    @Override
    <C extends Command> void register(Class<C> commandType, CommandHandler handler) {
        handlers.put(commandType, handler);
    }

    @Override
    void dispatch(Command command) {
        CommandHandler handler = handlers.get(command.getClass());
        if (handler == null) {
            throw new IllegalArgumentException("No handler registered for command type " + command.getClass());
        }
        handler.handle(command);
    }
}