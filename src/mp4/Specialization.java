package mp4;

public class Specialization {
    private String name;
    private String shortName;
    private int durationInDays;
    
    private final static int maxDurationInDays = 730;
    private final static int minimalDurationInDays = 365;

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
    
    
}
