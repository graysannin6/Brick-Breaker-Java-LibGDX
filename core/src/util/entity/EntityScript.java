/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util.entity;

/**
 *
 * @author chris
 * @param <T>
 */
public interface EntityScript<T extends EntityBase> {
    
    void added(T entity);
    
    void removed(T removed);
    
    void update(float delta);
    
    boolean isFinished();
    
    
    
    
}
