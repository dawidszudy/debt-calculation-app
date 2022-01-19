package pl.pp.project.service;

import pl.pp.project.model.Due;

import java.util.ArrayList;
import java.util.List;

public class DueService {

    private final List<Due> listDues = new ArrayList<>();

    public void addDueToCalculation(Due due) {
        listDues.add(due);
    }

    public List<Due> getListDues() {
        return listDues;
    }

    @Override
    public String toString() {
        return "AllDues{" +
                "listDues=" + "\n" + listDues +
                '}';
    }

}
