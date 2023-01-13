package org.grp2.kernel;

public interface Command {

    default String name() {
        return this.getClass().getSimpleName();
    }
}
