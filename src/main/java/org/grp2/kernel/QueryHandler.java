package org.grp2.kernel;

public interface QueryHandler<Q extends Query, R> {
    R handle(Q query);
}
