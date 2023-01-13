package org.grp2.kernel;

public interface Event {
    default String name() {
        return getClass().getSimpleName();
    }
}
