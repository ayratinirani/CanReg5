package canreg.server.database;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author ervikm
 */
public class PopulationDataset extends DatabaseRecord implements Serializable {

    static String ID_KEY = "ID";
    static String ID_PDS_KEY = "PDS_ID";
    static String PDS_NAME_KEY = "PDS_NAME";
    static String FILTER_KEY = "FILTER";
    static String DATE_KEY = "DATE";
    static String SOURCE_KEY = "SOURCE";
    static String AGE_GROUP_STRUCTURE_KEY = "AGE_GROUP_STRUCTURE";
    static String DESCRIPTION_KEY = "DESCRIPTION";
    static String WORLD_POPULATION_ID_KEY = "WORLD_POPULATION_ID";
    static String WORLD_POPULATION_BOOL_KEY = "WORLD_POPULATION_BOOL";
    static AgeGroupStructure[] AGE_GROUP_STRUCTURES = {new AgeGroupStructure(5,85)};
    
    private int populationDatasetID = -1;
    private String populationDatasetName = null;
    private String filter = null;
    private int date = 0;
    private String source = "";
    private AgeGroupStructure ageGroupStructure = new AgeGroupStructure(5, 85);
    private String description = "";
    private boolean worldPopulationBool = false;
    private int worldPopulationID = 0;
    private LinkedList<PopulationDatasetsEntry> ageGroups;
    
    /**
     * Creates a new instance of PopulationDatasetsEntry
     */
    public PopulationDataset() {
        super();
        ageGroups = new LinkedList<PopulationDatasetsEntry>();
    }

    public void flushAgeGroups() {
        ageGroups = new LinkedList<PopulationDatasetsEntry>();
    }

    @Override
    public String toString() {
        return populationDatasetName;
    }

    public int getPopulationDatasetID() {
        return populationDatasetID;
    }

    public void setPopulationDatasetID(int populationDatasetID) {
        this.populationDatasetID = populationDatasetID;
    }

    public String getPopulationDatasetName() {
        return populationDatasetName;
    }

    public void setPopulationDatasetName(String populationDatasetName) {
        this.populationDatasetName = populationDatasetName;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public AgeGroupStructure getAgeGroupStructure() {
        return ageGroupStructure;
    }

    public void setAgeGroupStructure(AgeGroupStructure ageGroupStructure) {
        this.ageGroupStructure = ageGroupStructure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWorldPopulationBool() {
        return worldPopulationBool;
    }

    public void setWorldPopulationBool(boolean worldPopulationBool) {
        this.worldPopulationBool = worldPopulationBool;
    }

    public int getWorldPopulationID() {
        return worldPopulationID;
    }

    public void setWorldPopulationID(int worldPopulationID) {
        this.worldPopulationID = worldPopulationID;
    }
    
    public void addAgeGroup(PopulationDatasetsEntry pdse){
        ageGroups.add(pdse);
    }
    
    public PopulationDatasetsEntry[] getAgeGroups(){
        return ageGroups.toArray(new PopulationDatasetsEntry[0]);
    }
}