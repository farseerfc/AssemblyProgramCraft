package org.apcdevpowered.vcpu32.vm.debugger.impl.request;

import org.apcdevpowered.vcpu32.vm.debugger.impl.VirtualMachineReferenceImpl;
import org.apcdevpowered.vcpu32.vm.debugger.request.ThreadDeathRequest;

public class ThreadDeathRequestImpl extends ThreadedRequestImpl implements ThreadDeathRequest
{
    public ThreadDeathRequestImpl(VirtualMachineReferenceImpl virtualMachineReference, EventRequestManagerImpl eventRequestManager)
    {
        super(virtualMachineReference, eventRequestManager);
    }
    @Override
    protected void requestStateChange(boolean isEnable)
    {
        virtualMachine().getHander().setThreadDeathRequestState(this, isEnable);
    }
}
