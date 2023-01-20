package org.grp2.api.trademe.domain.dto.account.consultant;

import java.util.ArrayList;

public class Skills {

    private final ArrayList<String> values;

    public Skills(ArrayList<String> values) {
        this.values = values;
    }

    public Skills() {
        this.values = new ArrayList<>();
    }

    public ArrayList<String> value() {
        return this.values;
    }

    public ArrayList<String> addSkill(String skill) {
        this.values.add(skill);
        return this.values;
    }

    public ArrayList<String> removeSkill(int skillId) {
        this.values.remove(skillId);
        return this.values;
    }

    public ArrayList<String> removeSkill(String skill) {
        this.values.remove(skill);
        return this.values;
    }
}
