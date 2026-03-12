package Corso_Java.mvc.model;

import Corso_Java.mvc.Enumerazioni.Role;

import java.util.Objects;

public class Manager extends Dipendente{
    double bonus;
    private Role roleType;


    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Role getRoleType() {
        return roleType;
    }

    public void setRoleType(Role roleType) {
        this.roleType = roleType;
    }

    @Override
    public String toString() {
        return  super.toString() + " bonus: " + bonus + " ruolo ricoperto: " + roleType.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return super.equals(o) && Double.compare(getBonus(), manager.getBonus()) == 0 && getRoleType() == manager.getRoleType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBonus(), getRoleType());
    }
}
