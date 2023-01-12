package org.grp2.kernel;

import java.util.HashMap;
import java.util.Map;

class QueryBus {
    private final Map<Class<? extends Query>, QueryHandler> handlers;

    QueryBus() {
        this.handlers = new HashMap<>();
    }

    <Q extends Query<R>, R> void register(Class<Q> queryType, QueryHandler<Q, R> handler) {
        handlers.put(queryType, handler);
    }

    <R> R dispatch(Query<R> query) {
        QueryHandler<Query<R>, R> handler = handlers.get(query.getClass());
        if (handler == null) {
            throw new IllegalArgumentException("No handler registered for query type " + query.getClass());
        }
        return handler.handle(query);
    }
}
