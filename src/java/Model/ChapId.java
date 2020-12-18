/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author A556U
 */

public class ChapId  implements Serializable {
    private int CourseId;
    private int ChapId;

    public ChapId(int CourseId, int ChapId) {
        this.CourseId = CourseId;
        this.ChapId = ChapId;
    }
    
}
