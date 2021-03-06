package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Event;
import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;


/**
 * Implements event command objects.
 *
 * @author Leonardo Irvin Pratama
 */
public class EventCommand extends Command {
    private final String description;
    private final String time;

    /**
     * Initializes an EventCommand object.
     *
     * @param description The task description.
     * @param time        The event time.
     */
    public EventCommand(String description, String time) {
        this.description = description;
        this.time = time;
    }

    /**
     * Executes the given command.
     *
     * @param tasks   Task list the user currently have.
     * @param ui      Tool to interact with user.
     * @param storage Storage to load and save data.
     */
    @Override
    public void executeCommand(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task newTask = new Event(description, false, time);
        tasks.addTask(newTask, ui);
        storage.saveTasks(tasks.getTasks());
        ui.getResponses();
    }
}
