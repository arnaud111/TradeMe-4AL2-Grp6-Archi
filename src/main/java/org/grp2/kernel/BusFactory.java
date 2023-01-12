package org.grp2.kernel;


class BusFactory {

    public static CommandBus defaultCommandBus() {
        return new DefaultCommandBus();
    }

    public static QueryBus defaultQueryBus() {
        return new DefaultQueryBus();
    }
}
