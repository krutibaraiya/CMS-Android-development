package set.forum;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by siddhant on 1/17/17.
 */

public class Discussion extends RealmObject {

    @PrimaryKey
    private int id;
    private  String name,subject ;
    private int forumId;
    private RealmList<Discussion> discussions;


    /*private int id;
    private String name;
    private int groupid;
    private int timemodified;
    private int usermodified;
    private int discussion;
    private int parent;
    private int userid;
    private int forumId;
    private String subject;
    private String message;*/

    public Discussion() {
    }
    public Discussion(int id, String name, String summary, RealmList<Discussion> discussions){

    }




        this.id = id;
        this.name = name;
        this.subject = subject;
        this.message = message;
        this.discussions = discussions;
    }

    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

   /* public int getGroupid() {
        return groupid;
    }

    public int getTimemodified() {
        return timemodified;
    }

    public int getUsermodified() {
        return usermodified;
    }

    public int getDiscussion() {
        return discussion;
    }

    public int getParent() {
        return parent;
    }

    public int getUserid() {
        return userid;*/
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getAttachment() {
        return attachment;
    }

    public RealmList<Attachment> getAttachments() {
        return attachments;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public int getMailnow() {
        return mailnow;
    }

    public String getUserfullname() {
        return userfullname;
    }

    public String getUserpictureurl() {
        return userpictureurl;
    }

    public String getNumreplies() {
        return numreplies;
    }

    public int getNumunread() {
        return numunread;
    }

    public boolean isPinned() {
        return pinned;
    }


    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    private String attachment;
    private RealmList<Attachment> attachments = null;
    private int totalscore;
    private int mailnow;
    private String userfullname;
    private String userpictureurl;
    private String numreplies;
    private int numunread;
    private boolean pinned;

}
