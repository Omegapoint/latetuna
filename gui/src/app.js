var CommentBox = React.createClass({
  render: function() {
    return (
      <div className="commentBox">
        <p>Hello, conference world! I am a CommentBox.</p>
        <button onClick={this.postConference}>POST Conference</button>
      </div>
    );
  },
  postConference: function() {
      var xhttp = new XMLHttpRequest();
      xhttp.open("POST", "/conference", true);
      xhttp.setRequestHeader("Content-type", "application/json");
      xhttp.send('{"name": "Foo"}');
  }
});
ReactDOM.render(
  <CommentBox />,
  document.getElementById('content')
);
