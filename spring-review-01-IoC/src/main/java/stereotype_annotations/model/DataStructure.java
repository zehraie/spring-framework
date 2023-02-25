package stereotype_annotations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//@AllArgsConstructor
@Data
public class DataStructure {
//    @Autowired
// asagidaki xtraHours xtraHours;   bu sekilde sadece constructor olmadan field injection, asagidaki ise constructor ile
  @NonNull
    ExtraHours extraHours;
  //  @Autowired   // NORMALDE ANOTATION KOYMAYA GEREK YOK
//    public DataStructure(ExtraHours extraHours) {
//        this.extraHours = extraHours;
//    }

    public void getTotalHours(){
        System.out.println("Total hours : "+(35+ extraHours.getHours()));
    }
}
