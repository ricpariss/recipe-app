package com.ricpariss.spring5.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ricpariss.spring5.enums.Difficulty;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	
	@Lob
	private String directions;
	
	@Lob
	private Byte[] image;
	
	// Specifying a cascade strategy means that when deleting a Recipe will also delete the associated notes
	@OneToOne(cascade=CascadeType.ALL)
	private Notes notes;
	
	// mapped by refers to the target property in the Ingredient class
	@OneToMany(cascade=CascadeType.ALL, mappedBy="recipe")
	private List<Ingredient> ingredients = new ArrayList<>();
	
	@Enumerated(value=EnumType.STRING)
	private  Difficulty difficulty;
	
	@ManyToMany
	@JoinTable(name="recipe_category", 
		joinColumns= {@JoinColumn(name="recipe_id")} , 
			inverseJoinColumns= {@JoinColumn(name="category_id")})		
	private List<Category> categories = new ArrayList<>();

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
	public Integer getCookTime() {
		return cookTime;
	}
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}
	public Integer getServings() {
		return servings;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
	public Notes getNotes() {
		return notes;
	}
	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", description=" + description + ", prepTime=" + prepTime + ", cookTime=" + cookTime
				+ ", servings=" + servings + ", source=" + source + ", url=" + url + ", directions=" + directions
				+ ", image=" + Arrays.toString(image) + ", notes=" + notes + ", ingredients=" + ingredients
				+ ", difficulty=" + difficulty + ", categories=" + categories + "]";
	}

	
}
