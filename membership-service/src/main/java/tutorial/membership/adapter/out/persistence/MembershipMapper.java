package tutorial.membership.adapter.out.persistence;

import org.springframework.stereotype.Component;
import tutorial.membership.adapter.out.persistence.MembershipJpaEntity;
import tutorial.membership.domain.Membership;

@Component
public class MembershipMapper {

    Membership mapToDomainEntity(MembershipJpaEntity membershipEntity) {
        System.out.println(membershipEntity.toString());
        return Membership.generateMember(
                new Membership.MembershipId(membershipEntity.getMembershipId()+""),
                new Membership.MembershipName(membershipEntity.getName()),
                new Membership.MembershipEmail(membershipEntity.getEmail()),
                new Membership.MembershipAddress(membershipEntity.getAddress()),
                new Membership.MembershipIsValid(membershipEntity.isValid())
        );
    }
}
