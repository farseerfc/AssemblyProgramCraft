package yuxuanchiadm.apc.vcpu32.vm.debugger.event;

import yuxuanchiadm.apc.vcpu32.vm.debugger.Mirror;

public interface EventQueue extends Mirror
{
    EventSet<? extends Event> remove() throws InterruptedException;
    EventSet<? extends Event> remove(long timeout) throws InterruptedException;
}