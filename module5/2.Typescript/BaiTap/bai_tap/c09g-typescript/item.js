var xHttp1 = new XMLHttpRequest();
xHttp1.onload = function () {
    if (this.status == 200) {
        console.log(xHttp1.responseText);
    }
};
xHttp1.open("GET", 'https://api.github.com/search/repositories?q=angular');
xHttp1.send();
console.log("End");
var interfaceItem = {
    id: 123123,
    node_id: "MDEwOlJlcG9zaXRvcnk4OTkxMzY1NQ",
    name: "bitcoin-abc",
    full_name: "Bitcoin-ABC/bitcoin-abc",
    private: true,
    owner: "\"login\": \"Bitcoin-ABC\",\n" +
        "        \"id\": 28255313,\n" +
        "        \"node_id\": \"MDEyOk9yZ2FuaXphdGlvbjI4MjU1MzEz\",\n" +
        "        \"avatar_url\": \"https://avatars.githubusercontent.com/u/28255313?v=4\",\n" +
        "        \"gravatar_id\": \"\",\n" +
        "        \"url\": \"https://api.github.com/users/Bitcoin-ABC\",\n" +
        "        \"html_url\": \"https://github.com/Bitcoin-ABC\",\n" +
        "        \"followers_url\": \"https://api.github.com/users/Bitcoin-ABC/followers\",\n" +
        "        \"following_url\": \"https://api.github.com/users/Bitcoin-ABC/following{/other_user}\",\n" +
        "        \"gists_url\": \"https://api.github.com/users/Bitcoin-ABC/gists{/gist_id}\",\n" +
        "        \"starred_url\": \"https://api.github.com/users/Bitcoin-ABC/starred{/owner}{/repo}\",\n" +
        "        \"subscriptions_url\": \"https://api.github.com/users/Bitcoin-ABC/subscriptions\",\n" +
        "        \"organizations_url\": \"https://api.github.com/users/Bitcoin-ABC/orgs\",\n" +
        "        \"repos_url\": \"https://api.github.com/users/Bitcoin-ABC/repos\",\n" +
        "        \"events_url\": \"https://api.github.com/users/Bitcoin-ABC/events{/privacy}\",\n" +
        "        \"received_events_url\": \"https://api.github.com/users/Bitcoin-ABC/received_events\",\n" +
        "        \"type\": \"Organization\",\n" +
        "        \"site_admin\": false"
};
// console.log(interfaceItem);
