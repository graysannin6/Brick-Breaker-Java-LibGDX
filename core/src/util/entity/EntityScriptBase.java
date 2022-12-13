/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.entity;

/**
 *
 * @author chris
 * @param <T>
 */
public abstract class EntityScriptBase<T extends EntityBase> implements EntityScript<T> {
    
    private boolean finished;
    protected T entity;

    @Override
    public void added(T entity) {
        this.entity = entity;
    }

    @Override
    public void removed(T removed) {
        this.entity = null;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
    
    protected void finish()
    {
        finished = true;
    }
    
    
    
}
