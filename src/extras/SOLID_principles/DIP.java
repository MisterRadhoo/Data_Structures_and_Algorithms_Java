package extras.SOLID_principles;

/**
 * DIP - Dependency inversion principles is a specific methodology for loosely coupled software modules.
 * The principle states:
 * A. High-level modules should not import anything from low-level modules. Both should depend on abstractions
 * (e.g., interfaces).
 * B. Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.
 */

/** Example:
 *  In a software development team, developers depend on an abstract version control system (e.g., Git) to manage
 *  and track changes to the codebase. They don't depend on specific details of how Git works
 *  internally.
 */
public class DIP {
}

// Interface for version control system  - Abstraction
interface IVersionControl {
    void commit(String message);
    void push();
    void pull();
}

// Git version control implementation - Low level module
class GitVersionControl implements IVersionControl {

    @Override
    public void commit(String message) {
        System.out.println("Commiting changes to Git with message: " + message);
    }

    @Override
    public void push() {
        System.out.println("Pushing changes to remote Git repository.");
    }

    @Override
    public void pull() {
        System.out.println("Pulling changes from remote Git repository. ");
    }
}

// Team class that relies on version control - High-level module
class DevelopmentTeam {
    private IVersionControl versionControl;         // DIP

    public DevelopmentTeam(IVersionControl versionControl) {
        this.versionControl = versionControl;
    }

    public void makeCommit(String message) {
        versionControl.commit(message);
    }

    public void performPush() {
        versionControl.push();
    }

    public void performPull() {
        versionControl.pull();
    }

}

// main
class Demo {

    public static void main(String[] args) {

        GitVersionControl git = new GitVersionControl();
        DevelopmentTeam developmentTeam = new DevelopmentTeam(git);

        developmentTeam.makeCommit("Initial commit");
        developmentTeam.performPush();
        developmentTeam.performPull();
    }
}
