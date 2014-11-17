package net.notanothercraft.mintcraft.item;

import javax.annotation.Nullable;

/**
 * Created by KJ4IPS on 11/16/2014.
 */
public interface ILockable {
    public boolean canUnlockWithKind(IUnlocker unlocker);
    public boolean isLocked();
    public boolean unLock(@Nullable IUnlocker unlocker);
    public boolean canUnLock(IUnlocker unlocker);
    public void keyTo(IUnlocker unlocker);
    public void setSecret(String secret);
    public String getSecret();
}
