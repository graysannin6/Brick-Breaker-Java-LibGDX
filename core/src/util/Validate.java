/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author chris
 */
public class Validate {
    private static final String DEFAULT_IS_NULL_MESSAGE = "The validate object is null";

    private static <T> void notNull(T object, String message) 
    {
        if(object == null)
        {
            throw new NullPointerException(message);
        }
    }

    public Validate() {
        
    }
    
    public static <T> void notNull(T object)
    {
        notNull(object, DEFAULT_IS_NULL_MESSAGE);
    }
    
}
