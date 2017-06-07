package xyz.redworkout.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugenij Kizim on 06-Jun-17.
 */

@Entity
@Table(name = "exercise")
public class Exercise implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_info_id")
    private ExerciseInfo exerciseInfo;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id")
    private Training training;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "exercise")
    private List<ExerciseSet> sets = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExerciseInfo getExerciseInfo() {
        return exerciseInfo;
    }

    public void setExerciseInfo(ExerciseInfo exerciseInfo) {
        this.exerciseInfo = exerciseInfo;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public List<ExerciseSet> getSets() {
        return sets;
    }

    public void setSets(List<ExerciseSet> sets) {
        this.sets = sets;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((exerciseInfo == null) ? 0 : exerciseInfo.hashCode());
        result = prime * result + ((training == null) ? 0 : training.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Exercise))
            return false;
        Exercise other = (Exercise) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (exerciseInfo == null) {
            if (other.exerciseInfo != null)
                return false;
        } else if (!exerciseInfo.equals(other.exerciseInfo))
            return false;
        if (training == null) {
            if (other.training != null)
                return false;
        } else if (!training.equals(other.training))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Exercise [id=" + id + "]";
    }
}
