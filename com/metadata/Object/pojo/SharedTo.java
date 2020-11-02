package com.metadata.Object.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sharedTo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class SharedTo {
    
    @XmlElement(name = "allCustomerPortalUsers")
    private String allCustomerPortalUsers;
    @XmlElement(name = "allInternalUsers")
    private String allInternalUsers;
    @XmlElement(name = "allPartnerUsers")
    private String allPartnerUsers;
    @XmlElement(name = "channelProgramGroup")
    private String channelProgramGroup;
    @XmlElement(name = "channelProgramGroups")
    private List<String> channelProgramGroups;
    @XmlElement(name = "group")
    private List<String> group;
    @XmlElement(name = "guestUser")
    private List<String> guestUser;
    @XmlElement(name = "groups")
    private List<String> groups;
    @XmlElement(name = "managerSubordinates")
    private List<String> managerSubordinates;
    @XmlElement(name = "managers")
    private List<String> managers;
    @XmlElement(name = "portalRole")
    private List<String> portalRole;
    @XmlElement(name = "portalRoleandSubordinates")
    private List<String> portalRoleandSubordinates;
    @XmlElement(name = "role")
    private List<String> role;
    @XmlElement(name = "roleAndSubordinates")
    private List<String> roleAndSubordinates;
    @XmlElement(name = "roleAndSubordinatesInternal")
    private List<String> roleAndSubordinatesInternal;
    @XmlElement(name = "roles")
    private List<String> roles;
    @XmlElement(name = "rolesAndSubordinates")
    private List<String> rolesAndSubordinates;
    @XmlElement(name = "territories")
    private List<String> territories;
    @XmlElement(name = "territoriesAndSubordinates")
    private List<String> territoriesAndSubordinates;
    @XmlElement(name = "territory")
    private List<String> territory;
    @XmlElement(name = "territoryAndSubordinates")
    private List<String> territoryAndSubordinates;
    @XmlElement(name = "queue")
    private List<String> queue;

    public String getAllCustomerPortalUsers() {
        return allCustomerPortalUsers;
    }

    public void setAllCustomerPortalUsers(String allCustomerPortalUsers) {
        this.allCustomerPortalUsers = allCustomerPortalUsers;
    }

    public String getAllInternalUsers() {
        return allInternalUsers;
    }

    public void setAllInternalUsers(String allInternalUsers) {
        this.allInternalUsers = allInternalUsers;
    }

    public String getAllPartnerUsers() {
        return allPartnerUsers;
    }

    public void setAllPartnerUsers(String allPartnerUsers) {
        this.allPartnerUsers = allPartnerUsers;
    }

    public String getChannelProgramGroup() {
        return channelProgramGroup;
    }

    public void setChannelProgramGroup(String channelProgramGroup) {
        this.channelProgramGroup = channelProgramGroup;
    }

    public List<String> getChannelProgramGroups() {
        return channelProgramGroups;
    }

    public void setChannelProgramGroups(List<String> channelProgramGroups) {
        this.channelProgramGroups = channelProgramGroups;
    }

    public List<String> getGroup() {
        return group;
    }

    public void setGroup(List<String> group) {
        this.group = group;
    }

    public List<String> getGuestUser() {
        return guestUser;
    }

    public void setGuestUser(List<String> guestUser) {
        this.guestUser = guestUser;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public List<String> getManagerSubordinates() {
        return managerSubordinates;
    }

    public void setManagerSubordinates(List<String> managerSubordinates) {
        this.managerSubordinates = managerSubordinates;
    }

    public List<String> getManagers() {
        return managers;
    }

    public void setManagers(List<String> managers) {
        this.managers = managers;
    }

    public List<String> getPortalRole() {
        return portalRole;
    }

    public void setPortalRole(List<String> portalRole) {
        this.portalRole = portalRole;
    }

    public List<String> getPortalRoleandSubordinates() {
        return portalRoleandSubordinates;
    }

    public void setPortalRoleandSubordinates(List<String> portalRoleandSubordinates) {
        this.portalRoleandSubordinates = portalRoleandSubordinates;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public List<String> getRoleAndSubordinates() {
        return roleAndSubordinates;
    }

    public void setRoleAndSubordinates(List<String> roleAndSubordinates) {
        this.roleAndSubordinates = roleAndSubordinates;
    }

    public List<String> getRoleAndSubordinatesInternal() {
        return roleAndSubordinatesInternal;
    }

    public void setRoleAndSubordinatesInternal(List<String> roleAndSubordinatesInternal) {
        this.roleAndSubordinatesInternal = roleAndSubordinatesInternal;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getRolesAndSubordinates() {
        return rolesAndSubordinates;
    }

    public void setRolesAndSubordinates(List<String> rolesAndSubordinates) {
        this.rolesAndSubordinates = rolesAndSubordinates;
    }

    public List<String> getTerritories() {
        return territories;
    }

    public void setTerritories(List<String> territories) {
        this.territories = territories;
    }

    public List<String> getTerritoriesAndSubordinates() {
        return territoriesAndSubordinates;
    }

    public void setTerritoriesAndSubordinates(List<String> territoriesAndSubordinates) {
        this.territoriesAndSubordinates = territoriesAndSubordinates;
    }

    public List<String> getTerritory() {
        return territory;
    }

    public void setTerritory(List<String> territory) {
        this.territory = territory;
    }

    public List<String> getTerritoryAndSubordinates() {
        return territoryAndSubordinates;
    }

    public void setTerritoryAndSubordinates(List<String> territoryAndSubordinates) {
        this.territoryAndSubordinates = territoryAndSubordinates;
    }

    public List<String> getQueue() {
        return queue;
    }

    public void setQueue(List<String> queue) {
        this.queue = queue;
    }

    @Override
    public int hashCode() {
        final Integer prime = 31;
        Integer result = 1;
        result = prime * result + ((allCustomerPortalUsers == null) ? 0 : allCustomerPortalUsers.hashCode());
        result = prime * result + ((allInternalUsers == null) ? 0 : allInternalUsers.hashCode());
        result = prime * result + ((allPartnerUsers == null) ? 0 : allPartnerUsers.hashCode());
        result = prime * result + ((channelProgramGroup == null) ? 0 : channelProgramGroup.hashCode());
        result = prime * result + ((channelProgramGroups == null) ? 0 : channelProgramGroups.hashCode());
        result = prime * result + ((group == null) ? 0 : group.hashCode());
        result = prime * result + ((groups == null) ? 0 : groups.hashCode());
        result = prime * result + ((guestUser == null) ? 0 : guestUser.hashCode());
        result = prime * result + ((managerSubordinates == null) ? 0 : managerSubordinates.hashCode());
        result = prime * result + ((managers == null) ? 0 : managers.hashCode());
        result = prime * result + ((portalRole == null) ? 0 : portalRole.hashCode());
        result = prime * result + ((portalRoleandSubordinates == null) ? 0 : portalRoleandSubordinates.hashCode());
        result = prime * result + ((queue == null) ? 0 : queue.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((roleAndSubordinates == null) ? 0 : roleAndSubordinates.hashCode());
        result = prime * result + ((roleAndSubordinatesInternal == null) ? 0 : roleAndSubordinatesInternal.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        result = prime * result + ((rolesAndSubordinates == null) ? 0 : rolesAndSubordinates.hashCode());
        result = prime * result + ((territories == null) ? 0 : territories.hashCode());
        result = prime * result + ((territoriesAndSubordinates == null) ? 0 : territoriesAndSubordinates.hashCode());
        result = prime * result + ((territory == null) ? 0 : territory.hashCode());
        result = prime * result + ((territoryAndSubordinates == null) ? 0 : territoryAndSubordinates.hashCode());
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
        SharedTo other = (SharedTo) obj;
        if (allCustomerPortalUsers == null) {
            if (other.allCustomerPortalUsers != null)
                return false;
        } else if (!allCustomerPortalUsers.equals(other.allCustomerPortalUsers))
            return false;
        if (allInternalUsers == null) {
            if (other.allInternalUsers != null)
                return false;
        } else if (!allInternalUsers.equals(other.allInternalUsers))
            return false;
        if (allPartnerUsers == null) {
            if (other.allPartnerUsers != null)
                return false;
        } else if (!allPartnerUsers.equals(other.allPartnerUsers))
            return false;
        if (channelProgramGroup == null) {
            if (other.channelProgramGroup != null)
                return false;
        } else if (!channelProgramGroup.equals(other.channelProgramGroup))
            return false;
        if (channelProgramGroups == null) {
            if (other.channelProgramGroups != null)
                return false;
        } else if (!channelProgramGroups.equals(other.channelProgramGroups))
            return false;
        if (group == null) {
            if (other.group != null)
                return false;
        } else if (!group.equals(other.group))
            return false;
        if (groups == null) {
            if (other.groups != null)
                return false;
        } else if (!groups.equals(other.groups))
            return false;
        if (guestUser == null) {
            if (other.guestUser != null)
                return false;
        } else if (!guestUser.equals(other.guestUser))
            return false;
        if (managerSubordinates == null) {
            if (other.managerSubordinates != null)
                return false;
        } else if (!managerSubordinates.equals(other.managerSubordinates))
            return false;
        if (managers == null) {
            if (other.managers != null)
                return false;
        } else if (!managers.equals(other.managers))
            return false;
        if (portalRole == null) {
            if (other.portalRole != null)
                return false;
        } else if (!portalRole.equals(other.portalRole))
            return false;
        if (portalRoleandSubordinates == null) {
            if (other.portalRoleandSubordinates != null)
                return false;
        } else if (!portalRoleandSubordinates.equals(other.portalRoleandSubordinates))
            return false;
        if (queue == null) {
            if (other.queue != null)
                return false;
        } else if (!queue.equals(other.queue))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (roleAndSubordinates == null) {
            if (other.roleAndSubordinates != null)
                return false;
        } else if (!roleAndSubordinates.equals(other.roleAndSubordinates))
            return false;
        if (roleAndSubordinatesInternal == null) {
            if (other.roleAndSubordinatesInternal != null)
                return false;
        } else if (!roleAndSubordinatesInternal.equals(other.roleAndSubordinatesInternal))
            return false;
        if (roles == null) {
            if (other.roles != null)
                return false;
        } else if (!roles.equals(other.roles))
            return false;
        if (rolesAndSubordinates == null) {
            if (other.rolesAndSubordinates != null)
                return false;
        } else if (!rolesAndSubordinates.equals(other.rolesAndSubordinates))
            return false;
        if (territories == null) {
            if (other.territories != null)
                return false;
        } else if (!territories.equals(other.territories))
            return false;
        if (territoriesAndSubordinates == null) {
            if (other.territoriesAndSubordinates != null)
                return false;
        } else if (!territoriesAndSubordinates.equals(other.territoriesAndSubordinates))
            return false;
        if (territory == null) {
            if (other.territory != null)
                return false;
        } else if (!territory.equals(other.territory))
            return false;
        if (territoryAndSubordinates == null) {
            if (other.territoryAndSubordinates != null)
                return false;
        } else if (!territoryAndSubordinates.equals(other.territoryAndSubordinates))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SharedTo [allCustomerPortalUsers=" + allCustomerPortalUsers + ", allInternalUsers=" + allInternalUsers
                + ", allPartnerUsers=" + allPartnerUsers + ", channelProgramGroup=" + channelProgramGroup
                + ", channelProgramGroups=" + channelProgramGroups + ", group=" + group + ", groups=" + groups
                + ", guestUser=" + guestUser + ", managerSubordinates=" + managerSubordinates + ", managers=" + managers
                + ", portalRole=" + portalRole + ", portalRoleandSubordinates=" + portalRoleandSubordinates + ", queue="
                + queue + ", role=" + role + ", roleAndSubordinates=" + roleAndSubordinates
                + ", roleAndSubordinatesInternal=" + roleAndSubordinatesInternal + ", roles=" + roles
                + ", rolesAndSubordinates=" + rolesAndSubordinates + ", territories=" + territories
                + ", territoriesAndSubordinates=" + territoriesAndSubordinates + ", territory=" + territory
                + ", territoryAndSubordinates=" + territoryAndSubordinates + "]";
    }
}
