/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.entity;

import com.badlogic.gdx.utils.Array;

/**
 *
 * @author chris
 */
public class ScriptController {
    
    private final Array<EntityScript<EntityBase>> scripts = new Array<EntityScript<EntityBase>>();
    private final EntityBase entity;
    
    
    public ScriptController(EntityBase entity) {
        this.entity = entity;
    }
    
    public void update(float delta)
    {
        for (int i = 0; i < scripts.size; i++) {
            EntityScript script = scripts.get(i);
            
            if (script.isFinished()) {
                scripts.removeIndex(i);
            }
            else
            {
                script.update(delta);
            }
        }
    }
    
    public void addScript(EntityScript<EntityBase> toAdd)
    {
        scripts.add(toAdd);
        toAdd.added(entity);
    }
    
    public void removeScript(EntityScript<EntityBase> toRemove)
    {
        scripts.removeValue(toRemove, true);
        toRemove.removed(entity);
    }
    
}
