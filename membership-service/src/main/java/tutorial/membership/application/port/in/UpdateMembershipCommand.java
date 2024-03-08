package tutorial.membership.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tutorial.common.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateMembershipCommand extends SelfValidating<UpdateMembershipCommand> {

    @NotNull
    private String membershipId;
    private String name;
    private String address;
    private String email;
    private boolean isValid;

}
