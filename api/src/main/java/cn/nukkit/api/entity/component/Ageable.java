package cn.nukkit.api.entity.component;

import javax.annotation.Nonnegative;

public interface Ageable extends EntityComponent {

    /**
     * Gets the age of this animal.
     *
     * @return Age
     */
    @Nonnegative
    int getAge();

    /**
     * Sets the age of this animal.
     *
     * @param age New age
     */
    void setAge(@Nonnegative int age);

    /**
     * Gets the current agelock.
     *
     * @return the current agelock
     */
    boolean getAgeLock();

    /**
     * Lock the age of the animal, setting this will prevent the animal from
     * maturing or getting ready for mating.
     *
     * @param lock new lock
     */
    void setAgeLock(boolean lock);

    /**
     * Sets the age of the animal to a baby
     */
    void setBaby();

    /**
     * Returns whether the animal is a baby
     *
     * @return baby
     */
    boolean isBaby();

    /**
     * Sets the age of the animal to an adult
     */
    void setAdult();

    /**
     * Returns true if the animal is an adult.
     *
     * @return return true if the animal is an adult
     */
    boolean isAdult();

    /**
     * Return the ability to breed of the animal.
     *
     * @return the ability to breed of the animal
     */
    boolean canBreed();

    /**
     * Set breedability of the animal, if the animal is a baby and set to
     * breed it will instantly grow up.
     *
     * @param breed breedability of the animal
     */
    void setBreed(boolean breed);
}
