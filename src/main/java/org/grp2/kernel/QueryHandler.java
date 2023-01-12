package org.grp2.kernel;

interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query);
}
