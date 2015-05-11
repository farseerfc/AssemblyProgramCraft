package yuxuanchiadm.apc.vcpu32.vm.debugger.impl.request;

import yuxuanchiadm.apc.vcpu32.vm.debugger.impl.LocationImpl;
import yuxuanchiadm.apc.vcpu32.vm.debugger.impl.VirtualMachineReferenceImpl;
import yuxuanchiadm.apc.vcpu32.vm.debugger.request.WatchpointRequest;

public abstract class WatchpointRequestImpl extends ThreadedRequestImpl implements WatchpointRequest
{
    private LocationImpl location;
    
    public WatchpointRequestImpl(VirtualMachineReferenceImpl virtualMachineReference, EventRequestManagerImpl eventRequestManager, LocationImpl location)
    {
        super(virtualMachineReference, eventRequestManager);
        this.location = location;
    }
    @Override
    public LocationImpl location()
    {
        return location;
    }
}
