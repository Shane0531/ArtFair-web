import { normalize, Schema, arrayOf } from 'normalizr'

const artist = new Schema('artist', { idAttribute: 'id' })

artistSchema.define({
  artist: { content: arrayOf(artist) }
})

export const receiveOne = (response) => {
  return normalize(response,{ content: artistSchema })
}

export const receiveAll = (response) => {
  return normalize(response,{ content: arrayOf(artistSchema) })
}
