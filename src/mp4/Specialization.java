package mp4;

import java.util.ArrayList;
import java.util.List;

public class Specialization {
    private String name;
    private String shortName;
    private int durationInDays;
    
    private final static int maxDurationInDays = 730;
    private final static int minimalDurationInDays = 365;
    // 1. Atrybuty ograniczone.

    private List<ChosenSpecialization> chosenSpecializations = new ArrayList<ChosenSpecialization>();
    
    public Specialization(String name, String shortName, int durationInDays) throws Exception {
        this.setDurationInDays(durationInDays);
        this.setName(name);
        this.setShortName(shortName);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) throws Exception {
        if(durationInDays < minimalDurationInDays){
            throw new Exception(
                String.format("Duration of cours in days can't be less than %d",
                minimalDurationInDays)
            );
        }
        if(durationInDays > maxDurationInDays){
            throw new Exception(
                String.format("Duration of cours in days can't be more than %d",
                maxDurationInDays)
            );
        }
        
        this.durationInDays = durationInDays;
    }
    
    public void addChosenSpecialization(ChosenSpecialization chosenSpecialization){
        if(!(chosenSpecialization == null) && !chosenSpecializations.contains(chosenSpecialization)){
            chosenSpecializations.add(chosenSpecialization);
            
            chosenSpecialization.setSpecialization(this);
        }
    }
    
    public void removeChosenSpecialization(ChosenSpecialization chosenSpecialization){
        if(chosenSpecializations.contains(chosenSpecialization)){
            chosenSpecializations.remove(chosenSpecialization);
            
            chosenSpecialization.removeSpecialization(this);
        }
    }
    
    public ChosenSpecialization[] getChosenSpecialization(){
        return chosenSpecializations.toArray(new ChosenSpecialization[0]);
    }

    public String getShortInfo(){
        return String.format(
            "Specialization{ name=%s, shortName=%s, durationInDays=%d ",
            shortName,
            name,
            durationInDays
        );
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(
                this.getShortInfo().concat("\nchosenSpecializations:")
        );
        ChosenSpecialization[] chosenSpecializations = getChosenSpecialization();
        for(int i = 0; i <  chosenSpecializations.length; i++){
            stringBuilder.append(
                    chosenSpecializations[i].getShortInfo().concat(", ")
            );
        }
        
        return stringBuilder.toString();
    }
    
    
    
}
