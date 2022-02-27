package com.warhammer.generate.character.model.name;


import com.warhammer.generate.character.model.description.Race;
import org.springframework.lang.Nullable;

import java.io.Serializable;

public class FullName implements Serializable {

    private String baseName;
    private String nickname;
    @Nullable
    private String connector;

    public FullName(String baseName, String nickname, @Nullable String connector) {
        this.baseName = baseName;
        this.nickname = nickname;
        this.connector = connector;
    }

    public String getCorrectName(Race race) {
        if (race == Race.ELF) {
            return baseName + " " + connector + " " + nickname;
        } else
            return baseName + " " + nickname;
    }

    @Override
    public String toString() {
        return '\n' + "FullName {" +
                ", name=" + baseName +
                ", name=" + nickname +
                ", name=" + connector +
                '}';
    }

    public String getBaseName() {
        return baseName;
    }

    public String getNickname() {
        return nickname;
    }

    @Nullable
    public String getConnector() {
        return connector;
    }

}
