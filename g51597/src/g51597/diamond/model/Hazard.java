package g51597.diamond.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * Hazard can make an exploration explored the same type of hazard is discovered
 * in the same cave
 *
 * @author Egide Kabanza
 */
public class Hazard implements Tile {

    private HazardType type;
    private boolean explorersEscapeReason;

    /**
     * Create hazard of a type
     *
     * @param type
     */
    public Hazard(HazardType type) {
        this.type = type;
    }

    @Override
    public void explore(List<Explorer> explorers) {

    }

    /**
     * get the Type of the hazard
     *
     * @return HazardType, the type of the hazard
     */
    public HazardType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hazard other = (Hazard) obj;
        return this.type == other.type;
    }

    @Override
    public String toString() {
        return "Hazard{" + "type=" + type + '}';
    }

    /**
     * Identify if tiles causes explorers to escape.
     *
     * @return boolean, true if the tile cause explorers to leave
     */
    public boolean isExplorersEscapeReason() {
        return explorersEscapeReason;
    }

    /**
     * Put explorersEscapeReason to true
     */
    public void escape() {
        explorersEscapeReason = true;
    }

}
