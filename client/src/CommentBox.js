import React from "react";

class CommentBox extends React.Component {
  render() {
    return (
        <div className="commentBox">
          <p>Hello, conference world! I am a CommentBox.</p>
          <button onClick={this.postConference}>POST Conference</button>
        </div>
    );
  }

  postConference() {
      fetch('/conference', {
          method: 'POST',
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
          },
          body: JSON.stringify({
              firstParam: 'yourValue',
              secondParam: 'yourOtherValue',
          })
      });

      //   var xhttp = new XMLHttpRequest();
      //   xhttp.open("POST", "/conference", true);
      //   xhttp.setRequestHeader("Content-type", "application/json");
      //   xhttp.send('{"name": "Foo"}');
  }
};

export default CommentBox
