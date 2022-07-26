package json;

public class Car {
    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    private Name name;
    private Model model;
    private Options options;
    private Details details;
    static class Name {
        private String salutation;
        private String givenName;
        private String surname;
        private String middleName;
    }
    static class Model {
        private String modelName;
        private String fuelType;
        private Boolean isHatchback;
        private Integer doors;
        private String color;
        private String manufactureDate;
    }
    static class Options {
        private Boolean isSeatsHeating;
        private Boolean isSteeringWheelHeating;
    }
    static class Details {
        private String winNumber;
        private String registrationNumber;
        private Integer maxSpeed;
    }

}

