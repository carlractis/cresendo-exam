A spring boot application that consumes Yelp API to provide business information and reviews. The endpoints requires authorization token generated from Yelp to include in header request.

<table>
  <thead>
    <td><strong>Name</strong></td>
    <td><strong>API</strong></td>
    <td><strong>Parameter</strong></td>
    <td><strong>Parameter Description</strong></td>
  </thead>
  <tbody>
    <tr>
      <td>Business List</td>
      <td>/yelp</td>
      <td>location</td>
      <td>Business location such as country name</td>
    </tr>
    <tr>
      <td>Business Details</td>
      <td>/yelp/{id}</td>
      <td></td>
      <td>Business id</td>
    </tr>
    <tr>
      <td>Business Reviews</td>
      <td>/yelp/{id}/reviews</td>
      <td></td>
      <td>Business id</td>
    </tr>
  </tbody>
</table>
