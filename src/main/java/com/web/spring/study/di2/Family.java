package com.web.spring.study.di2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Family {

    @Value("john")
    private String name;

    @Value("#{${members : {'father', 'mother', 'mother', 'brother'}}}")
    private Set<String> members;

    @Value("#{${hobbies : {'sleeping', 'watching', 'watching', 'playing'}}}")
    private List<String> hobbies;

    @Value("#{${height : {father: '180', mother: '174'}}}")
    private Map<String, Integer> height;

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getMembers() {
        return members;
    }

    public void setMembers(Set<String> members) {
        this.members = members;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<String, Integer> getHeight() {
        return height;
    }

    public void setHeight(Map<String, Integer> height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Family{" + "name=" + name + ", members=" + members + ", hobbies=" + hobbies + ", height=" + height + '}';
    }

}
