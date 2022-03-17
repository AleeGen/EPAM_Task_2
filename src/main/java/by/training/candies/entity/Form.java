package by.training.candies.entity;

public enum Form {
    RECTANGULAR("Rectangular"),
    ROUND("Round"),
    SQUARE("Square"),
    OVAL("Oval"),
    RELIEF("Relief"),
    FREE;
    private final String typeForm;

    Form() {
        typeForm = "";
    }

    Form(String form) {
        this.typeForm = form;
    }

    public static Form getForm(String typeForm) {
        for (Form forms : Form.values()) {
            if (forms.typeForm.equals(typeForm)) {
                return forms;
            }
        }
        return FREE;
    }
}
