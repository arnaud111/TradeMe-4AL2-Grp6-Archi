package org.grp2.kernel;

public interface EventDispatcher<E extends Event> {

    void dispatch(E event);

    void register(Class<E> eventClass, EventHandler<E> handler);
}
