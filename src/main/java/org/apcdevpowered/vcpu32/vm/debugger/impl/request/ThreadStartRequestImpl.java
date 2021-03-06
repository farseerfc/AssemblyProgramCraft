package org.apcdevpowered.vcpu32.vm.debugger.impl.request;

import org.apcdevpowered.vcpu32.vm.debugger.impl.VirtualMachineReferenceImpl;
import org.apcdevpowered.vcpu32.vm.debugger.request.ThreadStartRequest;

public class ThreadStartRequestImpl extends ThreadedRequestImpl implements ThreadStartRequest
{
    public ThreadStartRequestImpl(VirtualMachineReferenceImpl virtualMachineReference, EventRequestManagerImpl eventRequestManager)
    {
        super(virtualMachineReference, eventRequestManager);
    }
    @Override
    protected void requestStateChange(boolean isEnable)
    {
        virtualMachine().getHander().setThreadStartRequestState(this, isEnable);
    }
}
