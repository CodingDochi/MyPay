package tutorial.membership.application.port.in;

import tutorial.membership.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);

}
