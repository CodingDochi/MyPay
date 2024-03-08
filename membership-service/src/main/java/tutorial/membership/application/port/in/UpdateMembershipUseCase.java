package tutorial.membership.application.port.in;

import tutorial.membership.application.port.in.UpdateMembershipCommand;
import tutorial.membership.domain.Membership;

public interface UpdateMembershipUseCase {

    Membership updateMembership(UpdateMembershipCommand command);

}
