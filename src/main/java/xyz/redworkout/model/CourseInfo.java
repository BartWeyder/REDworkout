package xyz.redworkout.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "course_info")
public class CourseInfo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    @Column(name = "course_name", nullable = false)
    private String courseName;

    @NotEmpty
    @Column(name = "course_description", nullable = false)
    private String courseDescription;

    @NotEmpty
    @Column(name = "trainings_per_week", nullable = false)
    private Integer trainingsPerWeek;

    @NotEmpty
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @NotEmpty
    @Column(name = "public_access", nullable = false)
    private boolean publicAccess;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private User author;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<TrainingInfo> trainingInfoList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Integer getTrainingsPerWeek() {
        return trainingsPerWeek;
    }

    public void setTrainingsPerWeek(Integer trainingsPerWeek) {
        this.trainingsPerWeek = trainingsPerWeek;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public boolean isPublicAccess() {
        return publicAccess;
    }

    public void setPublicAccess(boolean publicAccess) {
        this.publicAccess = publicAccess;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

   public List<TrainingInfo> getTrainingInfoList() {
        return trainingInfoList;
    }

    public void setTrainingInfoList(List<TrainingInfo> exerciseInfoList) {
        this.trainingInfoList = exerciseInfoList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((courseDescription == null) ? 0 : courseDescription.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        CourseInfo other = (CourseInfo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (courseDescription == null) {
            if (other.courseDescription != null)
                return false;
        } else if (!courseDescription.equals(other.courseDescription))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CourseInfo [id=" + id + ", courseName=" + courseName + ", courseDescription=" + courseDescription +
                ", trainingsPerWeek=" + trainingsPerWeek + ", duration=" + duration + "]";
    }
}

