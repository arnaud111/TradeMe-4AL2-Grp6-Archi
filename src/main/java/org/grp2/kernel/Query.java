package org.grp2.kernel;

public interface Query {
    default String name() {
        return this.getClass().getSimpleName();
    }
}
