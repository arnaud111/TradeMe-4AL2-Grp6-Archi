package org.grp2.kernel;

import java.util.HashMap;
import java.util.Map;

public interface CommandBus<C extends Command> {
    <R> R post(C command);

    <R> void register(Class<C> commandClass, CommandHandler<C, R> commandHandler);
}
